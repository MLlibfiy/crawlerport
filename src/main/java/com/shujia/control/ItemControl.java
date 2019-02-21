package com.shujia.control;


import com.shujia.bean.ItemInfo;
import com.shujia.util.HBaseDAOImp;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.util.Bytes;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ItemControl {

    private HBaseDAOImp dao = new HBaseDAOImp();


    @RequestMapping(value = "/getItems", method = RequestMethod.GET)
    public ArrayList<ItemInfo> getItems(String words) {

        ArrayList<ItemInfo> itemInfos = new ArrayList<>();
        //查询索引表
        Result result = dao.getOneRow("index", DigestUtils.md5Hex(words).toUpperCase());

        if (result.isEmpty()){
            return itemInfos;
        }

        Cell cell = result.listCells().get(0);
        String ids = Bytes.toString(CellUtil.cloneValue(cell));


        for (String id : ids.split("_")) {

            ItemInfo itemInfo = new ItemInfo();

            Result item_info = dao.getOneRow("item_info", id);
            for (Cell cell1 : item_info.listCells()) {
                String qualifier = Bytes.toString(CellUtil.cloneQualifier(cell1));
                String value = Bytes.toString(CellUtil.cloneValue(cell1));
                if ("price".equals(qualifier)){
                    itemInfo.setPrice(value);
                }
                if ("StockStateName".equals(qualifier)){
                    itemInfo.setStockStateName(value);
                }
                if ("vender".equals(qualifier)){
                    itemInfo.setVender(value);
                }
                if ("website".equals(qualifier)){
                    itemInfo.setWebsite(value);
                }
                if ("url".equals(qualifier)){
                    itemInfo.setUrl(value);
                }
                if ("productColor".equals(qualifier)){
                    itemInfo.setProductColor(value);
                }
                if ("productSize".equals(qualifier)){
                    itemInfo.setProductSize(value);
                }
                if ("name".equals(qualifier)){
                    itemInfo.setName(value);
                }
            }

            itemInfos.add(itemInfo);
        }

        System.out.println(words);
        return itemInfos;
    }
}
