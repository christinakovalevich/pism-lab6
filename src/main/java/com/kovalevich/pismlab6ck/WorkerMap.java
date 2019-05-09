package com.kovalevich.pismlab6ck;

import java.io.Serializable;
import java.util.Map;

public interface WorkerMap extends Serializable {

    Map<String, String> getWorkers();

}
