package io.github.oliviercailloux.y2017.jxmcda.utils;


import javax.xml.bind.annotation.XmlElement;

import io.github.oliviercailloux.y2017.jxmcda.entities.XmcdaModularTypes;
 
public class MyMap {
 
   public String key;
   @XmlElement
   public XmcdaModularTypes value;
 
}