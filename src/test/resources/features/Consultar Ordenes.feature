
@consultaYCreacionOrdenes
Feature: Consulta y creacion de ordenes

  Scenario: Creacion de ordenes
    When hago la creacion del pedido con los datos 12 , 12 , 12 , "2024-07-24T17:34:16.239+0000" ,"placed", y 0
    Then el codigo de respuesta debe ser 200
    And la respuesta del body tiene que tener los datos 12 , 12 , 12 , "2024-07-24T17:34:16.239+0000" ,"placed", y 0

  Scenario Outline: Consulta de ordenes
    Given la url "https://petstore.swagger.io/v2/" del servicio
    When hago la consulta del pedido con id <id>
    Then el codigo de status debe ser 200
    And La respuesta del cuerpo debe contener la orden con id <id>
    Examples:
    | id |
    | 12 |






