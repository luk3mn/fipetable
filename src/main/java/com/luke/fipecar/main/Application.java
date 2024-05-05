package com.luke.fipecar.main;

import com.luke.fipecar.model.Model;
import com.luke.fipecar.model.Rate;
import com.luke.fipecar.model.Vehicle;
import com.luke.fipecar.model.VehicleCode;
import com.luke.fipecar.service.ApiConsumption;
import com.luke.fipecar.service.ConvertData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Application {

    private final Scanner scanner = new Scanner(System.in);
    private final ApiConsumption consumption = new ApiConsumption();
    private final ConvertData convert = new ConvertData();

    private String response;
    private String vehicleUrl;

    public void showOptions() {

        System.out.println("""
                ***** Opções *****
                Carro
                Moto
                Caminhão
                
                Escolha uma das opções para consultar valores:
                """);
        var option = this.scanner.nextLine();

        if (option.toLowerCase().contains("car")) {
            vehicleUrl = "carros/marcas";
            response = consumption.extractData(vehicleUrl);
        } else if (option.toLowerCase().contains("mot")) {
            vehicleUrl = "motos/marcas";
            response = consumption.extractData(vehicleUrl);
        } else if (option.toLowerCase().contains("cami")) {
            vehicleUrl = "caminhoes/marcas";
            response = consumption.extractData(vehicleUrl);
        } else {
            System.out.println("Opção inválida");
        }

        var vehicle = convert.getList(response, Vehicle.class);
        vehicle.stream()
                .sorted(Comparator.comparing(Vehicle::code))
                .forEach(System.out::println);

        System.out.println("\nInforme o código da marca para a consulta: ");
        var brandCode = scanner.nextLine();

        response = consumption.extractData(vehicleUrl + "/" + brandCode + "/modelos");
        var modelVehicle = convert.getData(response, Model.class);
        modelVehicle.models().stream()
                .sorted(Comparator.comparing(Vehicle::code))
                .forEach(System.out::println);

        System.out.println("\nDigite um trecho do nome do veículo para consulta: ");
        var carName = scanner.nextLine();

        modelVehicle.models().stream()
                .sorted(Comparator.comparing(Vehicle::code))
                .filter(v -> v.name().toLowerCase().contains(carName))
                .forEach(System.out::println);

        System.out.println("\nDigite o código do modelo para consultar valores: ");
        var modelCode = scanner.nextLine();

        response = consumption.extractData(vehicleUrl + "/" + brandCode + "/modelos/" + modelCode + "/anos");
        var vehicles = convert.getList(response, VehicleCode.class);


        for (VehicleCode vehicleCode : vehicles) {
            response = consumption.extractData(vehicleUrl + "/" + brandCode + "/modelos/" + modelCode + "/anos/" + vehicleCode.code());
            var rate = convert.getData(response, Rate.class);
            System.out.println(rate);
        }

    }
}
