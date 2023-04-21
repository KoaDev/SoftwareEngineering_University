/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examples.workTrucksMonitoring.repository;

import examples.workTrucksMonitoring.model.Truck;
import java.util.List;

/**
 *
 * @author mihai.hulea
 */
public interface ITruckRepository {
    public void save(Truck t);
    public List<Truck> readAll();
}
