# Etapa 1: Build da aplicação React
FROM node:20 as builder

WORKDIR /app

# Copiar package.json e install dependencies
COPY package*.json ./
RUN npm ci

# Copiar código fonte e buildar a aplicação
COPY . .
RUN npm run build

# Etapa 2: Servir os arquivos buildados
FROM node:20-alpine

WORKDIR /app

# Instalar um servidor estático (ex: serve)
RUN npm install -g serve

# Copiar apenas os arquivos buildados da etapa anterior
COPY --from=builder /app/build ./build

# Comando para rodar o servidor
CMD ["serve", "-s", "-l", "80", "build"]

