package cn.losemen.edu.service.impl;

import cn.losemen.common.util.ExcelImportUtil;
import cn.losemen.edu.entity.Subject;
import cn.losemen.edu.mapper.SubjectMapper;
import cn.losemen.edu.service.SubjectService;
import cn.losemen.edu.vo.SubjectAllVo;
import cn.losemen.edu.vo.SubjectNestedVo;
import cn.losemen.edu.vo.SubjectVo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author HuangZhen
 * @since 2020-04-01
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Override
    @Transactional
    public List<String> batchImport(MultipartFile file) throws Exception {
        //定义错误的消息列表
        ArrayList<String> errors = new ArrayList<>();
        //创建工具类对象
        ExcelImportUtil excelImportUtil = new ExcelImportUtil(file.getInputStream());
        //获取工作表
        HSSFSheet sheet = excelImportUtil.getSheet();
        //获取行数
        int rowCount = sheet.getPhysicalNumberOfRows();
        //判断行数
        if(rowCount <= 1) {
            errors.add("请填写数据");
            return errors;
        }
        //遍历行数
        for(int i = 1;i < rowCount;i++) {
            //获取每一行
            HSSFRow row = sheet.getRow(i);
            if(row != null) {
                //获取一级分类
                String levelOne = "";
                //获取每一行的第一个值
                HSSFCell cell = row.getCell(0);
                if(cell != null) {
                    //将单元格内容转化成字符串
                    levelOne = excelImportUtil.getCellValue(cell).trim();
                    //判断值是否为空
                    if(StringUtils.isEmpty(levelOne)) {
                        errors.add("第" + i + "行一级分类为空");
                        continue;
                    }
                }
                //判断一级标题是否重复
                Subject byTitle = this.getByTitle(levelOne);
                String parentId = null;
                if(byTitle == null) {
                    //将一级标题放入到数据库中
                    Subject subject = new Subject();
                    subject.setTitle(levelOne);
                    subject.setSort(i);
                    baseMapper.insert(subject);
                    parentId = subject.getId();
                } else {
                    parentId = byTitle.getId();
                }
                //获取第二级分类
                String levelTwo = "";
                //获取每一行第二个值
                HSSFCell cellTwo = row.getCell(1);
                //判断是否为空
                if(cellTwo != null) {
                    levelTwo = excelImportUtil.getCellValue(cellTwo).trim();
                    if(StringUtils.isEmpty(levelTwo)) {
                        errors.add("第" + i + "行二级分类为空");
                        continue;
                    }
                }
                //判断二级分类是否为空
                Subject twoByTitle = this.getTwoByTitle(levelTwo, parentId);
                if (twoByTitle == null) {
                    //将二级分类添加到数据库
                    Subject subjectTwo = new Subject();
                    subjectTwo.setTitle(levelTwo);
                    subjectTwo.setParentId(parentId);
                    subjectTwo.setSort(i);
                    baseMapper.insert(subjectTwo);
                }
            }
        }
        //返回错误的信息
        return errors;
    }
    /*
    根据分类名称查询一级分类是否存在
     */
    private Subject getByTitle(String title) {
        QueryWrapper<Subject> subjectQueryWrapper = new QueryWrapper<>();
        //判断是否存在
        subjectQueryWrapper.eq("title",title);
        //判断是否是一级标题
        subjectQueryWrapper.eq("parent_id","0");
        //返回查询到的分类信息
        return baseMapper.selectOne(subjectQueryWrapper);
    }
    /*
    根据分类名称以及父分类判断是否为二级标题
     */
    public Subject getTwoByTitle(String title,String parentId) {
        QueryWrapper<Subject> subjectQueryWrapper = new QueryWrapper<>();
        subjectQueryWrapper.eq("title",title);
        subjectQueryWrapper.eq("parent_id",parentId);
        Subject subject = baseMapper.selectOne(subjectQueryWrapper);
        return subject;
    }
    @Override
    public List<SubjectNestedVo> nestedList() {

        //最终要的到的数据列表
        ArrayList<SubjectNestedVo> subjectNestedVoArrayList = new ArrayList<>();

        //获取一级分类数据记录
        QueryWrapper<Subject> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("parent_id", 0);
        queryWrapper.orderByAsc("sort", "id");
        List<Subject> subjects = baseMapper.selectList(queryWrapper);

        //获取二级分类数据记录 TODO
        QueryWrapper<Subject> queryWrapper2 = new QueryWrapper<>();
        queryWrapper2.ne("parent_id", 0);
        queryWrapper2.orderByAsc("sort", "id");
        List<Subject> subSubjects = baseMapper.selectList(queryWrapper2);
        //填充一级分类vo数据
        int count = subjects.size();
        for (int i = 0; i < count; i++) {
            Subject subject = subjects.get(i);

            //创建一级类别vo对象
            SubjectNestedVo subjectNestedVo = new SubjectNestedVo();
            BeanUtils.copyProperties(subject, subjectNestedVo);
            subjectNestedVoArrayList.add(subjectNestedVo);

            //填充二级分类vo数据 TODO
            ArrayList<SubjectVo> subjectVoArrayList = new ArrayList<>();
            int count2 = subSubjects.size();
            for (int j = 0; j < count2; j++) {

                Subject subSubject = subSubjects.get(j);
                if(subject.getId().equals(subSubject.getParentId())){

                    //创建二级类别vo对象
                    SubjectVo subjectVo = new SubjectVo();
                    BeanUtils.copyProperties(subSubject, subjectVo);
                    subjectVoArrayList.add(subjectVo);
                }
            }
            subjectNestedVo.setChildren(subjectVoArrayList);
        }

        return subjectNestedVoArrayList;
    }

    @Override
    public List<SubjectAllVo> allList() {
        return baseMapper.selectSubjectList("0");
    }
}
