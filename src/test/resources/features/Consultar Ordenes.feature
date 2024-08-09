
@consultaYCreacionOrdenes
Feature: Consulta y creacion de ordenes

  Scenario Outline: Creacion de ordenes
    When hago la creacion del pedido con los datos id <id> , petId <petId> , quantity <quantity> , shipDate <shipDate>, status <status>, y complete <complete>
    Then el codigo de status debe ser 200
    And la respuesta del body tiene que tener los datos <id>,<petId>,<quantity>,<shipDate>,<status>,<complete>
    Examples:
      | id | petId | quantity | shipDate                 | status | complete |
      | 2  | 2     | 2        | 2024-07-24T17:34:16.239+0000 | placed | false    |
      | 15 | 12    | 19       | 2024-07-24T17:34:16.239+0000 | placed | true     |
      | 16 | 12    | 20       | 2024-07-24T17:34:16.239+0000 | placed | false    |

  Scenario Outline: Consulta de ordenes
    Given la url "https://petstore.swagger.io/v2/" del servicio
    When hago la consulta del pedido con id <id>
    Then el codigo de status debe ser 200
    And La respuesta del cuerpo debe contener la orden con id <id>
    Examples:
    | id |
    | 2 |
    | 15 |
    | 16 |









