package com.luke.fipecar.main;

import com.luke.fipecar.model.Model;
import com.luke.fipecar.model.Vehicle;
import com.luke.fipecar.service.ApiConsumption;
import com.luke.fipecar.service.ConvertData;

import java.util.Comparator;
import java.util.Scanner;

public class Application {

    private final Scanner scanner = new Scanner(System.in);
    private final ApiConsumption consumption = new ApiConsumption();
    private final ConvertData convert = new ConvertData();

    public void showOptions() {

        System.out.println("""
                ***** Opções *****
                Carro
                Moto
                Caminhão
                
                Escolha uma das opções:
                """);
        var option = this.scanner.nextLine();

        String resp = "";
        if (option.toLowerCase().contains("car")) {
            resp = consumption.extractData("carros/marcas");
        } else if (option.toLowerCase().contains("mot")) {
            resp = consumption.extractData("motos/marcas");
        } else if (option.toLowerCase().contains("cami")) {
            resp = consumption.extractData("caminhoes/marcas");
        } else {
            System.out.println("Opção inválida");
        }

        var vehicle = convert.getList(resp, Vehicle.class);
        vehicle.stream()
                .sorted(Comparator.comparing(Vehicle::code))
                .forEach(System.out::println);

        System.out.println("Informe o código da marca para a consulta: ");
        String codeModel = scanner.nextLine();

        resp = consumption.extractData("carros/marcas/" + codeModel + "/modelos");
        var modelVehicle = convert.getData(resp, Model.class);
        modelVehicle.models().stream()
                .sorted(Comparator.comparing(Vehicle::code))
                .forEach(System.out::println);

        // TODO: pegar "um trecho da marca do carro" para buscar um carro

    }
}
