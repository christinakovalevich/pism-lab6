package com.kovalevich.pismlab6ck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface Config {
    String MAPPED_NAME = "StudentMap";
    int STUDENT_MAP_SIZE = 10;
    int STUDENT_MARKS_LIST_SIZE = 5;
    int MAX_MARK_SIZE = 10;
    int UNSATISFACRORY_MARK = 2;

    List<String> STUDENT_SURNAMES = new ArrayList<String>(Arrays.asList("Petrov", "Semenov", "Vasilevskaya",
            "Antonov", "Ivanov", "Ptushkin", "Kusnetsov", "Sharohov", "Zhuck", "Alexeev"));
}
