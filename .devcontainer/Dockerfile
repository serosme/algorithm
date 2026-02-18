FROM maven:3.9.12-eclipse-temurin-25-noble

COPY ubuntu.sources /etc/apt/sources.list.d/ubuntu.sources

COPY settings.xml /home/ubuntu/.m2/settings.xml

RUN apt update && \
    apt upgrade -y

# RUN apt update && \
#     apt upgrade -y && \
#     apt install -y sudo && \
#     echo "node ALL=(ALL) NOPASSWD:ALL" >> /etc/sudoers && \
#     apt install -y locales && \
#     sed -i 's/# en_US.UTF-8 UTF-8/en_US.UTF-8 UTF-8/' /etc/locale.gen && \
#     locale-gen

# ENV LANG=en_US.UTF-8

# RUN corepack enable pnpm

ENTRYPOINT ["sleep", "infinity"]
