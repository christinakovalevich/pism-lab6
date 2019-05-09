package com.kovalevich.pismlab6ck;

import javax.ejb.Stateless;
import java.util.*;

@Stateless(mappedName = Config.MAPPED_NAME)
public class WorkerMapImpl implements MyBeanLocal, MyBeanRemote {

    private Map<String, String> workersMap;

    private void createMap() {

        int initialCapacity = 10;

//        initialize map
        workersMap = new HashMap<String, String>(initialCapacity);

//        Fill map with workers
        workersMap.put("Олеговишкин", "Минск.Приозерная.12");
        workersMap.put("Масалькес", "Москва.Садовое Кольцо.3");
        workersMap.put("Убунчик", "Москва.Победная.200");
        workersMap.put("Вакуленко", "Минск.Рафиева.100");
        workersMap.put("Магамендов", "Пинск.Лагодная.13");
        workersMap.put("Антоненко", "Боровляны.Луговая.1");
        workersMap.put("Кисегач", "Санкт-петербург.Мостовая.6");
        workersMap.put("Цыплакова", "Витебск.Ленина.202");
        workersMap.put("Иванов", "Минск.Автозаводская.200");
        workersMap.put("Пушкин", "Минск.Пушкина.99");
        workersMap.put("Кириленко", "Минск.Притыцкого.100");
    }

    public Map<String, String> getWorkers() {
        if (workersMap == null) {
            createMap();
        }
        Map<String, String> targetWorkersMap = new HashMap<String, String>(workersMap.size());

        for (String key : workersMap.keySet()) {
            String [] arr = workersMap.get(key).split("\\.");
            String city = arr[0];
            String street = arr[1];
            String buildingNumber = arr[2];
            if (isTargetCity(city) && isTargetBuildingNumber(buildingNumber)) {
                targetWorkersMap.put(key, city + "." + street + "." + buildingNumber);
            }
        }
        return targetWorkersMap;
    }

    private boolean isTargetCity(String city) {
        String targetCity = "минск";

        return city.toLowerCase().trim().equals(targetCity);
    }

    private boolean isTargetBuildingNumber(String buildingNumber) {
        String targetBuildingNumber1 = "100";
        String targetBuildingNumber2 = "200";

        return buildingNumber.toLowerCase().trim().equals(targetBuildingNumber1) ||
                buildingNumber.toLowerCase().trim().equals(targetBuildingNumber2);
    }

}
