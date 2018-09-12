package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.DuplicationDaoException;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.dao.manadatoryValueDaoException;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFile2Dao implements StudentDao {

    static String defaultFilename = "data/student2.dat";
    String filename;
    private List<Student> list = new ArrayList<>();

    public StudentFile2Dao(String filename) {
        this.filename=filename;
        
        File dataFile = new File(filename);
        try(
             FileInputStream in0 = new FileInputStream(dataFile);
             BufferedInputStream in1=new BufferedInputStream(in0);
             ObjectInputStream in = new ObjectInputStream(in1);)
        {
            /*list=(List<Student>)in.readObject();   */                 
            while(true) {
                try {
                Student m = (Student)in.readObject();
                list.add(m);
                }catch(Exception e) {
                    break;
                }
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    public StudentFile2Dao() {
      this(defaultFilename);
      //주의! 생성자 안에서의 생성자 호출은 반드시 첫번쨰 문장이어야 함. 
    }

    private void save() {
        File dataFile = new File(filename);
        try(
                FileOutputStream out0 = new FileOutputStream(dataFile);
                BufferedOutputStream out1=new BufferedOutputStream(out0);
                ObjectOutputStream out = new ObjectOutputStream(out1);
                ) 
        {
            /*out.writeObject(list);*/
            for(Student s:list) {
            out.writeObject(s);
        }
        out.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Student student)throws DuplicationDaoException,manadatoryValueDaoException {
        
        if(student.getEmail().length() == 0 ||
           student.getName().length() == 0 ||
           student.getPassword().length() == 0)
            throw new manadatoryValueDaoException("필수항목이 비어있습니다.");
        
        for (Student item : list) {
            if (item.getEmail().equals(student.getEmail())) {
               throw new DuplicationDaoException("이메일이 중복됩니다");
            }
        }
        list.add(student);
        save(); //다 지우고 insert 하는 방식. 좋지 않음.. 
        return 1;
    }

    public List<Student> findAll() {
        return list;
    }

    public Student findByEmail(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for (Student item : list) {
            if (item.getEmail().equals(email)) {
                list.remove(item);
                save();
                return 1;
            }
        }
        return 0;
    }
}








