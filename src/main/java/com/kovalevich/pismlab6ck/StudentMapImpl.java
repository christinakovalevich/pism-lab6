package com.kovalevich.pismlab6ck;

import javax.ejb.Stateless;
import java.util.*;

@Stateless(mappedName = Config.MAPPED_NAME)
public class StudentMapImpl implements MyBeanLocal, MyBeanRemote {

    private Map<String, List<Short>> studentMap;

    public void createMap() {
        studentMap = new HashMap<String, List<Short>>();

        for (int i = 0; i < Config.STUDENT_MAP_SIZE; i++) {
            List<Short> marks = new ArrayList<Short>(5);

            Random random = new Random(System.currentTimeMillis());
            for (int j = 0; j < Config.STUDENT_MARKS_LIST_SIZE; j++) {
                marks.add((short) random.nextInt(Config.MAX_MARK_SIZE));
            }

            studentMap.put(Config.STUDENT_SURNAMES.get(i), marks);
        }

        System.out.println(studentMap);

    }

    public Map<String, List<Short>> getSatisfactoryStudentMap() {
        if (studentMap == null) {
            createMap();
        }
        Map<String, List<Short>> satisfactoryStudentsMap =
                new HashMap<String, List<Short>>(Config.STUDENT_MAP_SIZE);

        for (String key : studentMap.keySet()) {
            boolean hasUnSatisfactoryMarks = false;
            for (short mark : studentMap.get(key)) {
                if (mark == Config.UNSATISFACRORY_MARK) {
                    hasUnSatisfactoryMarks = true;
                }
            }
            if (!hasUnSatisfactoryMarks) {
                satisfactoryStudentsMap.put(key, studentMap.get(key));
            }
        }

        return satisfactoryStudentsMap;
    }
}
