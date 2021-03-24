# sandbox-module-adapter
モジュールをCI時に差し替えるサンドボックス実装

## プロジェクト構成

* app
  * モジュールをCI時に切替できるようにするアプリケーションプロジェクト
* module-base
  * 差し替え対象となるモジュールのIFと基底クラスを持つプロジェクト。各モジュールはこのプロジェクトをapiスコープで依存に追加して実装する。
* module-a
  * module-baseの切替用モジュールA
* module-b
  * module-baseの切替用モジュールB

## 手順

1. プロジェクトのビルド

    ```
    cd ./module-base
    ./gradlew build publishToMavenLocal
    cd ../module-a
    ./gradlew build publishToMavenLocal
    cd ../module-b
    ./gradlew build publishToMavenLocal
    ```

2. アプリケーションのビルド

* ベースアプリケーションのビルド

    ```
    cd ./app
    ./gradlew build
    ```
  app/build/libs に app-base-0.0.1-SNAPSHOT.jar が作成される

* モジュールAのビルド

    ```
    cd ./app
    ./gradlew build -PMODULE_ID=a
    ```
  app/build/libs に app-a-0.0.1-SNAPSHOT.jar が作成される

* モジュールBのビルド

    ```
    cd ./app
    ./gradlew build -PMODULE_ID=b
    ```
  app/build/libs に app-b-0.0.1-SNAPSHOT.jar が作成される

## 確認

http://localhost:8080/ で以下のようにCIでビルドしたモジュールによって振る舞いが変更できる

* module-base
  * I'm base logic.
* module-a
  * I'm module A!!!
* module-b
  * I'm module B!!!