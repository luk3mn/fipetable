package com.luke.fipecar.main;

import com.luke.fipecar.model.Vehicle;
import com.luke.fipecar.service.ApiConsumption;
import com.luke.fipecar.service.ConvertData;

import java.util.Scanner;

public class Application {
    public void showOptions() {

        ApiConsumption consumption = new ApiConsumption();
        ConvertData convert = new ConvertData();
        Scanner scanner = new Scanner(System.in);

        System.out.println("""
                ***** Opções *****
                Carro
                Moto
                Caminhão
                """);
        System.out.println("Escolha uma das opções: ");
        var option = scanner.nextLine();

        option = option.toLowerCase();
        if (option.equals("carro")) {
            System.out.println(option);
            var resp = consumption.getData();
            Vehicle vehicle = convert.getData(resp, Vehicle.class);
            // TODO: fix response to convert
            System.out.println(vehicle);
        } else if (option.equals("moto")) {
            System.out.println(option);
        } else if (option.equals("caminhao") | option.equals("caminhão")) {
            System.out.println(option);
        } else {
            System.out.println("Opção inválida");
        }

    }
}
