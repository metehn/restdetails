package com.metehan.restdetails.entity;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@XmlRootElement() //bunu yazmazsan rest/xml/binding de hata verir!
public class Product {

    private long productId;
    private String productName;
    private double salesPrice;

}
