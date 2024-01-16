package org.example.springProject.jsonTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.example.springProject.jsonTest.data.StoreDetail;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class StoreArrange {

    public static void main(String[] args) {
        try(InputStream in = StoreArrange.class.getResourceAsStream("/suganyaData.json")) {
            ObjectMapper mapper = new ObjectMapper();
            String result = new BufferedReader(new InputStreamReader(in)).lines()
                    .collect(Collectors.joining());
            StoreDetail[] storeDetails = mapper.readValue(result, StoreDetail[].class);
            System.out.println(storeDetails.length >0 ? storeDetails[0].getStore() : "no value");

            List<StoreList> storeLists = arrangeStoresByDetail(storeDetails);
            ObjectWriter ow = mapper.writerWithDefaultPrettyPrinter();
            System.out.println(ow.writeValueAsString(storeLists));

        } catch(IOException io) {
            io.printStackTrace();
        }
    }

    public static List<StoreList> arrangeStoresByDetail(StoreDetail[] storeDetails) {

        Map<String, StoreList> storeListMap = new HashMap<>();
        for(StoreDetail detail : storeDetails){
            if(storeListMap.containsKey(makeKey(detail.getDepartment(), detail.getStoreClass(), detail.getSubClass()))) {
                continue;
            }
            List<Integer> matchstores = Arrays.stream(storeDetails).filter(
                    storeDetail -> detail.test(storeDetail)).map(sd -> sd.getStore()).collect(Collectors.toList());

            //if(!matchstores.isEmpty()) {
                storeListMap.put(
                        makeKey(detail.getDepartment(), detail.getStoreClass(), detail.getSubClass()),
                        new StoreList(matchstores, detail.getDepartment(),  detail.getStoreClass(), detail.getSubClass()));
            //}

        }

        return storeListMap.values().stream().collect(Collectors.toList());

    }

    private static String makeKey(int dep, int storeClass, int subClass) {
        return dep +":" + storeClass +":" + subClass;
    }
}
