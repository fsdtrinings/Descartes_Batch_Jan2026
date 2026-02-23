

README TEXT

1) set hbm2ddl as CREATE , refresh the schema 

2) set hbm2ddl as UPDATE , for next insertion onwards 

Classes to Check
1) Customer class , changed AppOrder relationship , added mappedby for dual ref.
2) AppOrder class , add Customer for Bi-directional , and now AppOrder class is responsible to insert FK in the DB
3) executes Day2OneToOne.java
4) MainOneToMany.java :- class responsible for data insertion
5) execute HQLDemos.java :- wrt HQL Queries 
--
