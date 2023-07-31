# RickandMortyAdventure

<br />
<p align="center">
  <h3 align="center">Rick and Morty Characters</h3>
</p>
<p align="center">
  <a href="#fluxo">Fluxo</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#tecnologias">Tecnologias</a>&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;
  <a href="#%EF%B8%8Froadmap">Roadmap</a>
</p>

<div align="center">
<img src="https://github.com/alini159/RickandMortyAdventure/assets/44498505/b6eade51-1c84-464d-89a4-47d5d5af4061" width="700px" />
</div>

<br>

## 🌱Fluxo

Eu controlei meu fluxo de desenvolvimento utilizando o kaban+trello, dividindo as tarefas em cards, cada um com sua checklists de D.o.R's (Definition of Ready), tentei seguir o gitflow, criando branchs pra cada feature e integrando elas na develop, até ter tudo pronto e mandar pra main:

* Listar os requisitos.
* Criar o trello com todos os requisitos.
* Puxar os cards na ordem que fazia sentido/prioridade 
* Meu fluxo foi:
  * Setup do projeto(arquiteturam injeção de dependencias e principais libs 📚)
  * Setup dos services(autenticão com api 🔐 e mapeamento de models)
  * Lista de personagens 🦸 - Sem a paginação em um primeiro momento pra deixar as coisas simples
  * Tratamento de erros❗ estilo sanduiche 🥪
  * Paging infinito ♾️
  * Ultima checada em tudo ☑️
  * Resolver erros do git 😧
 
    
## 🚀Tecnologias
Eu usei as seguintes tecnologias durante :

* <b><a href="https://square.github.io/retrofit/">Retrofit2</a></b> - A lib padrão quando o assunto é http no android e o que eu uso(e a melhor na minha humilde opinião).
* <b><a href="https://insert-koin.io/docs/quickstart/android/">Koin</a></b> - Escolhi o Koin pra não precisar ficar escrevendo muito boilerplate.
* <b><a href= "https://developer.android.com/topic/libraries/architecture/paging/v3-overview?hl=pt-br">Paging3</a></b> - A melhor lib pra fazer paginação ela oferece recursos de paginação eficientes, carregamento automático e cache para otimizar o desempenho e a experiência do usuário.
* <b><a href="https://developer.android.com/guide/navigation/navigation-getting-started">Jetpack Navigation</a></b> - Utilizei o naviagtion para navegar entre os fragmentos.
* <b><a href="https://github.com/bumptech/glide">Glide 4</a></b> - Rápida e facil de usar e faz o caching das imagens pra mim.
* <b><a href="https://material.io/develop/android">Material Components</a></b> - Vários components prontos e também tinha o tab layout que eu precisava pra paginação.
* <b><a href="https://medium.com/edersonmelo/clean-architecture-com-mvvm-em-aplica%C3%A7%C3%B5es-android-153eaeb1e37d">mvvm + clean architecture android</a></b> -Proporcionando uma arquitetura bem estruturada, separação clara de responsabilidades e facilita a manutenção e escalabilidade do aplicativo..
* <b><a href= "https://developer.android.com/kotlin/flow?hl=pt-br">Flow</a></b> -ideal para programação reativa e assíncrona em aplicativos Android, oferecendo uma API concisa, tratamento de backpressure e fácil integração com corrotinas..

## 🗺️Roadmap
Gostei do resultado mais eu gostaria de adicionar mais algumas coisas no app, pra dar aquele toque especial:

* Tela de detalhes dos personagens(com direito a animation).
* Teste unitarios e Integrados.(sera inserido nas proximas features)
