package com.nttdata.bootcamp.mscustomers.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document

public class Customer {
    
   /*
    private String id;
    private String firstName;
    private String lastName;
    private String nroDoc;
    private String type;
    */
	@Id
    private Integer item;
    
    private int dni; 
    
    private String accNum;  //account number
    private String move_type; //movement type
    private String move_det;  //movement detail
    private double amou_move; //amount movement
    private String date_time; //date time
    
    
    
    
}
