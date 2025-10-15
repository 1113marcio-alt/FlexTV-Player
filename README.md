FlexTV Player - Um Reprodutor de IPTV para Android TV
FlexTV Player é um projeto de código aberto para um reprodutor de IPTV completo e configurável para a plataforma Android TV, projetado com uma interface limpa e navegação intuitiva via controle remoto.

Requisitos Funcionais
✔️ Suporte a Playlists: Carrega listas de canais via URL remota (M3U, M3U8) e arquivos locais.

✔️ Integração com API Xtream: Suporte para login via servidor, usuário e senha.

✔️ Player de Vídeo Avançado (ExoPlayer):

Seleção de qualidade de stream.

Suporte a HLS, MPEG-TS, RTMP.

Suporte a legendas e múltiplas faixas de áudio.

▶️ Em desenvolvimento: Timeshift (pausar/retroceder ao vivo) e Gravação.

✔️ Interface Leanback para Android TV:

Tela principal com categorias e canais.

Guia de Programação (EPG) completo.

Gestão de canais Favoritos.

Histórico de canais assistidos.

✔️ Guia de Programação (EPG): Suporte para fontes XMLTV remotas.

✔️ Organização:

Agrupamento automático de canais por categorias.

Funcionalidade de pesquisa.

▶️ Em desenvolvimento: Perfis de usuário e Controle Parental com PIN.

✔️ Configurações Avançadas:

Ajuste de buffer do player.

Opção de proxy e headers HTTP customizados.

Atualização automática de playlists e EPG.

Importação e exportação de configurações (JSON).

✔️ Logs e Debug: Visualização de logs no app e opção para exportar.

✔️ Internacionalização: Suporte inicial para Inglês, Português (Brasil) e Português (Portugal).

Arquitetura do Projeto
O aplicativo é construído utilizando a arquitetura recomendada pelo Google, MVVM (Model-View-ViewModel), com os seguintes componentes principais:

Linguagem: 100% Kotlin.

Assincronia: Kotlin Coroutines para operações em background.

UI (Interface): Android TV Leanback para uma experiência nativa de TV.

Player de Mídia: ExoPlayer (Media3) para reprodução de vídeo robusta e customizável.

Networking: Retrofit e OkHttp para requisições HTTP eficientes.

Banco de Dados Local: Room para persistir favoritos, histórico e dados de EPG.

Injeção de Dependência: (Recomendado) Hilt para gerenciar dependências de forma escalável.

Estrutura dos Pacotes
com.flextv.player
├── data/                # Repositório, fontes de dados (rede e local)
│   ├── local/           # Classes do Room (DAO, Entidades, Database)
│   └── remote/          # Classes do Retrofit (ApiService, DTOs)
├── model/               # Modelos de dados da aplicação (Canal, Programa, etc.)
├── player/              # Lógica relacionada ao ExoPlayer
├── ui/                  # Fragments, Activities, ViewModels e Adapters da UI
│   ├── main/            # Tela principal
│   ├── player/          # Tela do player
│   └── settings/        # Tela de configurações
└── utils/               # Classes utilitárias

Como Compilar e Testar
Pré-requisitos
Android Studio (versão mais recente recomendada)

Git

1. Clonar o Repositório
git clone [https://github.com/1113marcio-alt/FlexTV-Player.git](https://github.com/1113marcio-alt/FlexTV-Player.git)
cd FlexTV-Player

2. Construir o APK de Debug
Abra o projeto no Android Studio e aguarde a sincronização do Gradle. Para construir o APK via linha de comando:

./gradlew assembleDebug

O APK gerado estará em app/build/outputs/apk/debug/app-debug.apk.

3. Testar no Emulador do Android Studio
Vá em Tools -> AVD Manager.

Clique em Create Virtual Device.

Selecione a categoria TV e escolha um dispositivo (ex: 1080p).

Selecione uma imagem de sistema e conclua a criação.

Inicie o emulador e execute o aplicativo a partir do Android Studio.

4. Instalar e Testar na Xiaomi TV (ou outra Android TV)
Habilitar Opções de Desenvolvedor na TV:

Vá para Configurações -> Sobre.

Clique repetidamente em Número da versão (ou Build) até ver a mensagem "Você agora é um desenvolvedor!".

Habilitar Depuração USB/ADB:

Volte para Configurações, procure por Opções de Desenvolvedor.

Ative a Depuração USB ou Depuração ADB.

Instalar via ADB (Wi-Fi ou USB):

Via Wi-Fi (mais fácil):

Encontre o endereço IP da sua TV em Configurações -> Rede.

No seu computador, abra o terminal e conecte-se à TV:

adb connect SEU_IP_DA_TV:5555

Instale o APK:

adb install app/build/outputs/apk/debug/app-debug.apk

Via Pen Drive (alternativa):

Copie o arquivo app-debug.apk para um pen drive.

Conecte o pen drive à TV.

Use um gerenciador de arquivos (como o "File Commander" ou similar, que pode precisar ser instalado da Play Store da TV) para navegar até o pen drive e instalar o APK.

Como Assinar o APK para Release
No Android Studio, vá em Build -> Generate Signed Bundle / APK....

Selecione APK e clique em Next.

Clique em Create new... para criar uma nova chave de assinatura (keystore).

Preencha as informações do formulário e guarde a senha e o arquivo .jks em um local seguro.

Selecione a chave criada, preencha as senhas e clique em Next.

Escolha a variante release e clique em Finish. O APK assinado estará na pasta app/release/.

Licença
Este projeto está licenciado sob a Licença MIT.
