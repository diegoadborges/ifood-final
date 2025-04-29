package me.diego;

import me.diego.domain.Order;
import me.diego.domain.User;
import me.diego.factory.ExpressOrderFactory;
import me.diego.factory.StandardOrderFactory;

public class IFoodDeliverySystem {
  public static void main(String[] args) {
    var standardFactory = StandardOrderFactory.getInstance();
    var expressFactory = ExpressOrderFactory.getInstance();

    Order standardOrder = standardFactory.createOrder("12345", "Restaurante Delícia");

    var cliente = new User("USR1", "Cliente 1");
    var restaurante = new User("RES1", "Restaurante 1");
    var entregador = new User("ENT1", "Entregador 1");

    standardOrder.addObserver(cliente);
    standardOrder.addObserver(restaurante);
    standardOrder.addObserver(entregador);

    System.out.println("=== Simulação do fluxo de entrega do iFood ===");

    System.out.println("Estado atual: " + standardOrder.getCurrentState().getDescription());

    System.out.println("\n--> Atualizando para Em Preparação");
    standardOrder.progressToNextState();

    System.out.println("\n--> Atualizando para Pronto para Entrega");
    standardOrder.progressToNextState();

    System.out.println("\n--> Atualizando para Retirado pelo Entregador");
    standardOrder.progressToNextState();

    System.out.println("\n--> Atualizando para A Caminho");
    standardOrder.progressToNextState();

    System.out.println("\n--> Atualizando para Entregue");
    standardOrder.progressToNextState();

    System.out.println("\n--> Tentativa de atualização após entrega");
    standardOrder.progressToNextState();

    System.out.println("\n=== Criando um pedido expresso ===");
    Order expressOrder = expressFactory.createOrder("RES2", "Restaurante rápido");
    expressOrder.addObserver(new User("USR2", "Cliente 2"));

    System.out.println(
        "Estado inicial do pedido expresso: " + expressOrder.getCurrentState().getDescription());
    expressOrder.progressToNextState();
  }
}
