package com.kovalevich.pismlab6ck;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public interface StudentMap extends Serializable {

    void createMap();

    Map<String, List<Short>> getSatisfactoryStudentMap();

}
