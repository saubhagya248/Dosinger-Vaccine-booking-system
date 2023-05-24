# Dosinger-Vaccine-booking-system
A backend Spring project which uses JPA/Hibernate to connect to database.
This Project is an organised project which consists of several packages Controller, Service, ServiceImpl, Repository, DTO's, Transformer
, Enum, Exception, Model.
It also hides the entity by using Response and Request DTO's (Data Transfer Object)

**Controller**
There are four controllers User, Doctor, Appointment, VaccinationCenter

**Service**
The service layer is abstracted by using interfaces, and the Impl package inside the service package provides the implementations of the service interfaces

**Enum**
This sub-package contains all the Enumerators 

**Exception**
This sub-package contains all the exceptions

**Model**
All the model classes are put inside the Model sub-package

**Transformer**
This package contains the data transformers which helps in converting DTO's to Entity and vice versa

**Repository**
This sub-package has repository interfaces which extends JpaRepository interface
