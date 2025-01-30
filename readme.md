# Journal Application 

## Learnt SpringBoot
### Auto-configuration and standalone applications
- SpringBoot is framework for build application in java ,it easy to create stand-alone, production-grade spring based application that you can just run., reduceing effort required to set up and configure  a **spring. application [???].**
- **beans === object --special kya ha --ek bar config kar le fir sab use karlege. done by AplicationContext**
- Context Pathc: locahhost:8080 "ke baad ka name/aplicatiion name ko is "
- try this on terminal ` ps aux | grep PID `


**Meven: build bange ke kaam  aata ha , or dependency manage karta ha**

- mvn package -creates jar
- mvn install -creates/moved jar to local
  `Installing /Users/vikasarya/Projects/ProjectName/pom.xml to /Users/vikasarya/.m2/repository/CompanyName/ProjectName/0.0.1-SNAPSHOT/ProjectName-0.0.1-SNAPSHOT.pom`
  Structure

- java | resource
- **pom.xml:**
- repackaging
  Internal  Working

- ` Car car =new Car() `  yaha hum/ma object create kar raha hu..
- but in spring :we ask to spring ki oject bana kar la kar do....yani ki object ke creation ko externalize kar rahe ha --control change ho gya so Inversion of control
- what is IOC -- ye karta ha ki pure project ki sari class/object rakha lega and jab requirement hogi de dega.
- aplication context --is way to achieve ioc container,
- how IOC container how to store ?? --scan karta ha,how to descide karge rakhen ka `@component`  wale class  ko rakha lega
- @component is annotations :: information provide karti ha jise par bhi likha ha. and all annotation having own specially .

- to create a bean/oject is just annotate any class with @component
- @springBootApplication : is ProjectNameApplication. === index.js |server.js. run it. and it always is one and put at main class
    - @configuration
    - @Enable AutoConfigurat
        - just putting dependency of mongodb/postgre just puting env type
    - @ComponentScan --find beans to store at ioc container
        - `package CompanyName.ProjectName;`  `// it scan in this package`
        - @restController ::same create as beans +something other special
        - @autowired ::write on field to ask object/bean to ioc

RestAPI: generate journal app :

class controller with @RestController is bean created

-  [﻿localhost:8080/](http://localhost:8080/) journal/id/2--path variabale
-  [﻿localhost:8080/](http://localhost:8080/) journal/id?name=vipul --these are request paramters
   understanding ORM,JPA,spring data JPA

- jpa is a way to achieve ORM,is set of rules , include interface and annotations that you use in your java class, requires a presistence proivder orm tools for implementation,
- jpa ko use kargo to 3 type ha :: hibernate ,eclipseLink and OpenJPA
- JPA is designed for Relational database ..by mongodb is schemaless
