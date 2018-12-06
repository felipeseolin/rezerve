                 UTFPR
Universidade Tecnológica Federal do Paraná
        Programação Desktop - SO35A

Alunos {
    Felipe Seolin Bento         R.A.: 1915959
    Rafael Fernandes Marques    R.A.: 1459783
}

Professor {
    Fabricio Martins Lopes
}

Projeto {

    O projeto gerenciamento de sala, foi evoluído e assim
    se tornou um projeto de reseva de salas, onde podem ser
    gerenciadas salas, usuários, reservas e entre outros.
   
    O sistema proposto visa automatizar e organizar este 
    processo de gerenciar salas de aula, laboratórios, 
    salas de reuniões e salas de estudos da universidade, 
    bem como evetuar reservas. 
}

Passos para execução {

    Obs.: O sistema possui permissões, o tipo de usuário
    mais completo é coordenador e administrador. Vale ob-
    servar que ambos podem gerar relatórios.
    Obs2.: Cada o NetBeans ou outra IDE aponte erro pois
    não consegue encontro o jdbc.jar, indique que este
    está localizado na pasta lib

    1. Crie um banco no Postgresql chamado "rezerve"
    2. Mude as credencias de usuario e senha reverentes
        ao banco de dados, em controller > BDController.java
    3. Execute o script: 01 - Inicia banco
    4. Execute o script: 02 - Inserts no banco
    5. Execute o arquivo em view > UsuarioCadastrar.java e
        cadastre um novo usuario, lembrando que a senha deve
        ter ao menos um caracter maiúsculo, minúsculo e número
    6. Após isto, inicie o projeto normalmente através
        da classe Home.java
    7. Os relatórios podem ser visualizados através do menu
        Gerenciar Reservas.

}