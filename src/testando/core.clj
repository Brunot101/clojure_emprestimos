 
(defn now [] (java.util.Date.))
(ns testando.core
   (:require [clojure.java.jdbc :as sql]))
   (def db-map {:subprotocol "mysql"
              :subname "//127.0.0.1:3306/teste?verifyServerCertificate=false&useSSL=true"
              :user "root"
              :password ""})

(def drop-emprestimos (sql/drop-table-ddl :emprestimos))
(def drop-parcelas (sql/drop-table-ddl :parcelas))

(defn insert-emprestimos [data_ini parcelas taxa_juros valor_emprestado saldo_devedor] (sql/insert! db-map  :emprestimos {:data_ini data_ini :parcelas parcelas :taxa_juros taxa_juros :valor_emprestado valor_emprestado :saldo_devedor saldo_devedor}))

(def emprestimos-table-ddl
  (sql/create-table-ddl :emprestimos
                         [[:id_emprestimo "int(11)" :primary :key :auto_increment]
                          [:data_ini :datetime]
                          [:parcelas :int]
                          [:taxa_juros :real]
                          [:valor_emprestado :float]
                          [:saldo_devedor :float]
                          [:id_usuario "int(11)"]
                          ]))
(def parcelas-table-ddl
  (sql/create-table-ddl :parcelas
                         [[:id_parcelas "int(11)" :primary :key :auto_increment]
                          [:vencimento "varchar(32)"]
                          [:valor_parcela :float]
                          [:status :int]  
                          ;; status will be 1 or 0
                          [:id_emprestimo "int(11)"]
                           ["FOREIGN KEY (id_emprestimo) REFERENCES emprestimos (id_emprestimo)"]
                          ]))


(defn -main
  
  [& args]
  

              
             
  ;;  (insert-emprestimos (java.time.LocalDateTime/now) 12 0.08 1000 1008)
  ;;  (println(sql/query db-map ["select data_ini from emprestimos"]))
  ;;   (println(java.time.LocalDateTime/now))
    
  ;;   (sql/db-do-commands db-map emprestimos-table-ddl)
  ;;  (sql/db-do-commands db-map parcelas-table-ddl)
   

    
)
