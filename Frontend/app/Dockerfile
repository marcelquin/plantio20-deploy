# Etapa 1: build da aplicação React
FROM node:18-alpine AS builder
WORKDIR /app
COPY . .
RUN npm install
RUN npm run build

# Etapa 2: servidor Nginx
FROM nginx:alpine
COPY --from=builder /app/build /usr/share/nginx/html

# Substitui o default.conf (opcional, mas recomendado)
COPY nginx.conf /etc/nginx/conf.d/default.conf

EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]
