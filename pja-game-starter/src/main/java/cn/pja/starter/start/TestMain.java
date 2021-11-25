package cn.pja.starter.start;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;

/**
 * @author 彭金安
 * @DATE 2021/10/24
 */
public class TestMain {

    public static void main(String[] args) {


        List<String> list = new ArrayList<>();
        List<String> list2 = Lists.newArrayList();
        List<String> list3 = Arrays.asList();
        List<String> list4 = new ArrayList<String>(){{}};

        Map<String, String> map = Maps.newHashMap();
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<String, String>(){{}};
        Map<String, String> map3 = ImmutableMap.of(
                "","",
                "",""
        );//Maps.immutableEnumMap();

    }
}
