# Etapa 1: Build do React
FROM node:18 AS builder

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia os arquivos de dependência e instala as dependências
COPY package*.json ./
RUN npm install

# Copia o restante da aplicação
COPY . .

# Gera o build de produção
RUN npm run build

# Etapa 2: Servir com 'serve'
FROM node:18-slim

# Instala o pacote 'serve' globalmente
RUN npm install -g serve

# Diretório onde o React será servido
WORKDIR /app

# Copia o build da etapa anterior
COPY --from=builder /app/build ./build

# Expõe a porta padrão
EXPOSE 80

# Comando padrão para servir o app
CMD ["serve", "-s", "build", "-l", "3000"]
