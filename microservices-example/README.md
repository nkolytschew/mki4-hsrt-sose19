# Simple Microservice Example

With Eureka for Service Discovery and Feign-Client for inter-service communication.

## Service Discovery
Please start [Service-Discover App](service.discovery) before you start the other applications, to ensure that your services can find each other.

## Mapping Service
[Mapping-Serivce App](mapping.service) is responsible for mapping from an API-Object to an Entity-Object. This service will be primary called by Registration-Service.

## Registration-Service
[Registration-Service App](registration.service) is responsible for creating and reading of User from a Database. Currently there is only a H2-Database, so you lose all information after a restart. This service uses _RestTemplate_ for communication.

## User Service
[User-Service App](user.service) this service is responsible to display the current user, stored within a database. The users are retrieved from Registration-Service. There is no mapping, so there is no communication with Mapping-Service. Opposite to Registration-Service, this service uses _FeignClient_ for inter-service communication.