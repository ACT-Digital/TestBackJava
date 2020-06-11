# Show me the code
#Lucas Pereira Rodrigues, processo seletivo para o Banco Santander
##Instruções

Você será avaliado pela usabilidade, por respeitar o design e pela arquitetura da API. 
É esperado que você consiga explicar as decisões que tomou durante o desenvolvimento através de commits.

* Requisitos Para executar a aplicaccao localhost:
Ter o servidor do mongo db instalado, se ja tiver instalado inicie o servico.
Ter O Sts Intalado, pois nao criei o build ainda da aplicação
Ter o java instalado
Suponhando que ja tenha tudo isso, incie o sts, no menu de navegação: file -> openProjects from File System -> cole o caminho do projeto
Com o projeto aberto: botao direito do mouse sobre o projeto-> runAs -> springBoot App

Quando o projeto inciar(Acompanhe pelo console)

Va  ate seu navegador e digite as opções:
*Executar com Swagger
*http://localhost:8080/swagger-ui.html#/usuarios/ -> endPoint raiz do usuario
*http://localhost:8080/swagger-ui.html#/usuarios/listall ->  -> retorna um JSON com todos os usuarios
*http://localhost:8080/swagger-ui.html#/usuarios/{seuid} ->  retorna um JSON com um usuario
*http://localhost:8080/swagger-ui.html#/usuarios/{seuid}/gastos ->  retorna um JSON com Todos os seus gastos

*Sem o Swagger
*http://localhost:8080/usuarios/ -> endPoint raiz do usuario
*http://localhost:8080/usuarios/findall -> retorna um JSON com todos os usuarios
*http://localhost:8080/usuarios/{seuid} ->  retorna um JSON com um usuario
*http://localhost:8080/usuarios/{seuid}/gastos ->  retorna um JSON com Todos os seus gastos



