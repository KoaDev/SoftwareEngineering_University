/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.serializableJson;

import lombok.*;

 /**
 * Default constructor is needed here for json object mapper to work!
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@ToString
public class Vehicle {
    @Getter @Setter
    private String plateNumber;
    @Getter @Setter
    private String latitude;
    @Getter @Setter
    private String longitude;
    @Getter @Setter
    private int speed;

  
}
