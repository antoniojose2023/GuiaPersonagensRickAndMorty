# 🛸 Guia de Personagens Rick and Morty

Aplicativo Android nativo, desenvolvido em **Kotlin**, que permite navegar, pesquisar e favoritar os personagens do universo de *Rick and Morty*, consumindo dados da [Rick and Morty API](https://rickandmortyapi.com/).

> Venha navegar e escolher seu personagem favorito da série Rick and Morty! 🍊

---

## 📱 Sobre o projeto

O **Guia de Personagens Rick and Morty** é um app de catálogo que exibe a lista completa de personagens da série, com informações como status (vivo, morto ou desconhecido), espécie, gênero, tipo e localização atual/de origem. O usuário pode pesquisar personagens pelo nome, filtrar resultados e marcar seus favoritos com um toque.

### ✨ Funcionalidades

- 📋 **Lista de personagens** — navegação por todos os personagens da série, com foto, status, espécie e localização.
- 🔍 **Busca por nome** — pesquisa em tempo real na lista de personagens.
- 🧰 **Visualização de erro** — tela apresentada quando a listagem retorna vázia.
- ❤️ **Favoritos** — botão de coração em cada card e na tela de detalhes para marcar personagens favoritos, além de um atalho para visualizar somente os favoritados.
- 🪐 **Tela de splash** — tela de abertura com identidade visual temática da série.
- 👤 **Tela de detalhes** — imagem em destaque do personagem e informações completas: status, espécie, local atual, gênero e tipo.

---

## 🖼️ Screenshots

| Splash  | Lista |  Busca  | Detalhes |  Error |
|:----:|:----:|:----:|:----:|:----:|
| <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/6ff67d26-116f-4cb8-8f05-8e0fc464fd24" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/69903226-9c15-4bba-aadf-9f89d2ddddf8" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/3e04a908-fea9-4947-824c-fe144a76e08c" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/2672966b-da00-4f15-9b94-729c00e48569" /> | <img width="1080" height="2424" alt="Image" src="https://github.com/user-attachments/assets/6fdc783c-5a99-4c5d-bf80-8356d0b57c62" /> |


---

## 🧪 Tecnologias

- **Kotlin** — linguagem principal do projeto
- **Android SDK** — desenvolvimento nativo Android
- **Gradle (Kotlin DSL)** — build system (`build.gradle.kts`, `settings.gradle.kts`)
- **[Rick and Morty API](https://rickandmortyapi.com/)** — API pública REST/GraphQL usada como fonte dos dados de personagens

---

## 📂 Estrutura do repositório

```
GuiaPersonagensRickAndMorty/
├── app/                     # Módulo principal do aplicativo Android
├── gradle/                  # Wrapper do Gradle
├── build.gradle.kts         # Configuração de build do projeto (nível raiz)
├── settings.gradle.kts      # Configuração dos módulos do projeto
├── gradle.properties        # Propriedades do Gradle
├── gradlew / gradlew.bat    # Scripts do Gradle Wrapper (Unix/Windows)
└── .gitignore
```

---

## 🚀 Como executar o projeto

### Pré-requisitos

- [Android Studio](https://developer.android.com/studio) (versão recente, Hedgehog ou superior recomendado)
- JDK 11 ou superior
- Um dispositivo físico ou emulador Android configurado
- Conexão com a internet (o app consome dados da API em tempo real)

### Passo a passo

1. Clone o repositório:
   ```bash
   git clone https://github.com/antoniojose2023/GuiaPersonagensRickAndMorty.git
   ```
2. Abra a pasta do projeto no **Android Studio**.
3. Aguarde a sincronização do Gradle ser concluída.
4. Selecione um emulador ou conecte um dispositivo físico via USB (com depuração USB ativada).
5. Clique em **Run ▶** ou use o atalho `Shift + F10`.

### Build via linha de comando

```bash
# Build completo do projeto
./gradlew build

# Gerar APK de debug
./gradlew :app:assembleDebug

# Instalar diretamente em um dispositivo/emulador conectado
./gradlew :app:installDebug
```

No Windows, substitua `./gradlew` por `gradlew.bat`.

---

## 🌐 API utilizada

Este projeto consome a **[Rick and Morty API](https://rickandmortyapi.com/)**, uma API pública e gratuita (sem necessidade de autenticação) que disponibiliza informações sobre personagens, localizações e episódios da série.

Endpoint base utilizado para personagens:
```
https://rickandmortyapi.com/api/character
```

Cada personagem retorna dados como `name`, `status`, `species`, `type`, `gender`, `location` e `image`, exibidos na listagem e na tela de detalhes do app.

---

## 🗺️ Roadmap / próximos passos

- [ ] Tela dedicada para listar apenas os personagens favoritados
- [ ] Filtros avançados (status, espécie, gênero) via bottom sheet
- [ ] Modo escuro
- [ ] Testes unitários e de UI

---

## 🤝 Contribuindo

Contribuições são bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/minha-feature`)
3. Faça commit das suas alterações (`git commit -m 'Adiciona minha feature'`)
4. Envie para a branch (`git push origin feature/minha-feature`)
5. Abra um Pull Request

---

## 📄 Licença

Distribuído sem uma licença definida no momento. Adicione um arquivo `LICENSE` ao repositório caso deseje definir os termos de uso e distribuição do código.

---

## 👤 Autor

Desenvolvido por **[antoniojose2023](https://github.com/antoniojose2023)**.

---

<p align="center">Feito com 💙 e kotlin </p>
