## AquaVidaManager
Sistema web desenvolvido para gerenciamento de piscicultura, permitindo o controle de tanques, peixes, vendas, parâmetros da água e gerenciamento de usuários com diferentes níveis de permissão.

O projeto foi desenvolvido utilizando arquitetura MVC com Java Web, JSP, Servlets, JDBC e MySQL.


## Funcionalidades
* Gerenciamento de Tanques
* Cadastro de tanques;
* Edição e exclusão;
* Controle de capacidade máxima;
* Visualização das informações dos tanques.
* Gerenciamento de Peixes
* Cadastro de peixes vinculados aos tanques;
* Controle de quantidade;
* Controle de preço unitário;
* Cálculo automático do valor total estimado;
* Edição e exclusão de registros.


# Controle Inteligente de Lotação dos Tanques
Funcionalidade bônus desenvolvida no projeto.

O sistema:

* verifica automaticamente a ocupação do tanque;
* calcula quantos peixes ainda podem ser adicionados;
* exibe alertas quando o tanque está próximo do limite;
* impede novos cadastros caso a capacidade máxima seja atingida.

Objetivo:

* evitar superlotação;
* melhorar o gerenciamento da produção;
* automatizar regras de negócio importantes do sistema.


# Controle de Usuários e Permissões
O sistema possui dois tipos de usuários:

* ADMIN;
* USER.


# Permissões ADMIN
* cadastrar registros;
* editar registros;
* excluir registros;
* alterar tipo de usuários;
* acessar funcionalidades administrativas.


# Permissões USER
* acesso limitado às funcionalidades do sistema;
* visualização de informações.


# Registro de Vendas
* Cadastro de vendas;
* Histórico de vendas realizadas;
* Controle de saída de peixes.


# Monitoramento da Água
Cadastro de:

* temperatura;
* pH;
* amônia;
* medições vinculadas aos tanques.


## Tecnologias Utilizadas
# Backend:
* Java
* Servlets
* JDBC

# Frontend:
* JSP
* HTML
* CSS
* JavaScript

# Banco de Dados
* MySQL

# Arquitetura
* MVC (Model-View-Controller)


## Fluxo do Sistema
O sistema segue o padrão MVC:

# View (JSP)
Responsável pelas interfaces do sistema.

# Controller (Servlets/Actions)
Responsável por:
* receber requisições;
* validar dados;
* aplicar regras de negócio;
* controlar o fluxo da aplicação.

# Model
Representação das entidades:
* usuário;
* tanque;
* peixe;
* venda;
* parâmetros da água.

# DAO
Responsável pela comunicação com o banco de dados.


## Funcionalidade Destaque
# Controle Inteligente de Lotação
Fluxo da funcionalidade:

1. Usuário realiza cadastro do peixe;
2. Sistema recebe os dados da interface JSP;
3. Backend consulta:
    * capacidade do tanque;
    * ocupação atual;
4. Sistema valida a lotação;
5. Caso o limite seja excedido:
    * cadastro é bloqueado;
    * mensagem de alerta é exibida;
6. Caso permitido:
    * dados são salvos no banco de dados.


## Segurança e Controle de Acesso
O sistema utiliza:

* autenticação por login;
* sessão HTTP;
* controle de permissões baseado no tipo do usuário.

As funcionalidades administrativas ficam disponíveis apenas para usuários ADMIN.


## Banco de Dados
Principais tabelas:
* usuario
* tanque
* peixe
* venda
* parametro_agua

Relacionamentos:
* peixes vinculados aos tanques;
* parâmetros da água vinculados aos tanques;
* controle de usuários e permissões.


## Objetivo do Projeto
O AquaVidaManager foi desenvolvido com o objetivo de aplicar conceitos de:

* desenvolvimento Java Web;
* arquitetura MVC;
* integração com banco de dados;
* autenticação e autorização;
* regras de negócio;
* organização de sistema em camadas.

## Demonstração do Sistema
Vídeo demonstrando o funcionamento do AquaVidaManager e explicação de algumas funcionalidades:

[https://drive.google.com/file/d/1C59AELyzjCoBHQ78rP4arS73f08FhzRO/view?usp=drive_link](LINK_DO_VIDEO)