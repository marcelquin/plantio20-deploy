# Estágio de build e produção
FROM node:18-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia os arquivos de package
COPY package*.json ./

# Instala as dependências
RUN npm install

# Copia o código fonte
COPY . .

# Gera o build de produção
RUN npm run build

# Instala um servidor estático simples
RUN npm install -g serve

# Expõe a porta 80
EXPOSE 3000

# Inicia o servidor
CMD ["serve", "-s", "build", "-l", "3000"]