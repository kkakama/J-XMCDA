package io.github.oliviercailloux.y2017.jxmcda.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.xml.bind.annotation.adapters.XmlAdapter;

import io.github.oliviercailloux.y2017.jxmcda.entities.XmcdaModularTypes;
  

/**
 * The goal was to adapt map to xmcdaModular schema (in xml format)
 * @author meskaoui
 *
 */
public final class MyMapAdapter extends XmlAdapter<MyMapType,Map<String, XmcdaModularTypes>> {
  
  
   @Override
   public Map<String, XmcdaModularTypes> unmarshal(MyMapType arg0) throws Exception {
      HashMap<String, XmcdaModularTypes> hashMap = new HashMap<String, XmcdaModularTypes>();
      for(MyMap myEntryType : arg0.entry) {
         hashMap.put(myEntryType.key, myEntryType.value);
      }
      return hashMap;
   }

@Override
public MyMapType marshal(Map<String, XmcdaModularTypes> v) throws Exception {
	 MyMapType myMapType = new MyMapType();
     for(Entry<String, XmcdaModularTypes> entry : v.entrySet()) {
        MyMap myMapEntryType = 
           new MyMap();
        myMapEntryType.key = entry.getKey();
        myMapEntryType.value = entry.getValue();
        myMapType.entry.add(myMapEntryType);
     }
     return myMapType;
}
  
}
