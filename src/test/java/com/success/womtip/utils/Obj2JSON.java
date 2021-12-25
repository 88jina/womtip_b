package com.success.womtip.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.success.womtip.entity.Menu;

public class Obj2JSON {



    public static String setJSONRequest(Object object) throws Exception{
        ObjectMapper objectMapper= new ObjectMapper();
        objectMapper.configure(SerializationFeature.WRAP_ROOT_VALUE,false);
        ObjectWriter ow = objectMapper.writer().withDefaultPrettyPrinter();
        return ow.writeValueAsString(object);
    }
}
