<h1 align="center">🎶 Java Chat 🎶</h1>

<p align="center">"Este projeto, desenvolvido em Java, foi uma parte integral das atividades avaliativas para a disciplina de Redes de Computadores na Universidade Federal de Juiz de Fora. O sistema de chat multithread, operado por terminal, demonstra a aplicação prática dos conceitos aprendidos. Ele incorpora recursos avançados como multithreading para lidar com múltiplas solicitações simultaneamente e comandos específicos como `@echo`, `@help` e `@quit` para melhorar a interação do usuário. Além disso, o sistema foi projetado para funcionar em uma rede local, permitindo a comunicação entre vários usuários na mesma rede desse dispositivo."</p>



<h4 align="center"> 
	☕ Java  ☕  Finalizado  ☕
</h4>

## 🏝️ Features
Um sistema básico de chat multithread em Java rodando em uma rede local e operado por terminal poderia ter as seguintes características:

1. **Multithreading**: O servidor executa um loop infinito para aceitar solicitações de entrada. Quando uma solicitação chega, ele atribui uma nova thread para lidar com a parte de comunicação¹. Isso permite que várias operações sejam realizadas ao mesmo tempo, economizando tempo e não bloqueando o usuário³.

2. **Comandos @echo, @help e @quit**: Esses comandos podem ser implementados para melhorar a interação do usuário. O comando `@echo` pode ser usado para enviar uma mensagem para todos os usuários, `@help` pode fornecer informações sobre como usar o chat e `@quit` pode ser usado para sair do chat.

3. **Comunicação Cliente-Servidor**: O servidor mantém um registro dos clientes conectados e suas threads correspondentes¹. Quando um cliente envia uma mensagem, o servidor a recebe e a encaminha para o destinatário pretendido¹.

4. **Execução em Rede Local**: O sistema de chat pode ser configurado para funcionar em uma rede local, permitindo que vários usuários na mesma rede se comuniquem entre si.


## 📌 Pré-requisitos

- Git
- Java 17

## 🎮 Rodando aplicação no windows

```bash
# Clone este repositório
git clone https://github.com/KleitonEwerton/JavaChat.git

# Acesse a pasta do projeto via terminal/cmd
cd JavaChat

# Acesse a pasta dos arquivos via terminal/cmd
cd src

# Compilando os arquivos
javac *.java

# Rodando o servidor (Deve ser o primeiro)
java EchoServer

# Rodando o Cliente (OBS: DEVE ABRIR UM NOVO TERMINAL PARA CADA CLIENTE e devem possuir nomes unicos)
java EchoClient nomeCliente1 localhost

# Rodando um segundo Cliente (OBS: DEVE ABRIR UM NOVO TERMINAL PARA CADA CLIENTE e devem possuir nomes unicos)
java EchoClient nomeCliente2 localhost

# Rodando um terceiro Cliente (OBS: DEVE ABRIR UM NOVO TERMINAL PARA CADA CLIENTE e devem possuir nomes unicos)
java EchoClient nomeCliente3 localhost

# Comando dos Cliente 
## @Help (ver um ajuda)
@help

## @echo msg (envia a msg para os clientes conectados no vervidor)
@echo seja todos bem vindos

## @quit (encerra a conexão desse cliente)
@quit 

"Este é um guia introdutório. Se houver alguma dúvida ou precisar de esclarecimentos adicionais, não hesite em entrar em contato."

```
## 🛠 Tecnologias

As seguintes ferramentas foram usadas na construção do projeto:


- [Git](https://git-scm.com/)
- [Java 17](https://www.oracle.com/java/technologies/downloads/)

## 👨‍💻 Autores
- Kleiton Ewerton de Oliveira - [GitHub](https://github.com/KleitonEwerton)
- Mariana Siano Pinto - [GitHub](https://github.com/MarianaSiano)

## 📞 Contatos
- kleitonewertonoliveira@gmail.com  
- https://github.com/MarianaSiano
