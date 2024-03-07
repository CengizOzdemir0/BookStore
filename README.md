# BookStore
Veri tabanı için docker üzerinde postgres üzerinde çalıştırmak için,
docker run -d -v /Users/cengizozdemir/var/folders:/data/db -p 5432:5432 -e POSTGRES_PASSWORD=test123 -e POSTGRES_USER=test123 -e POSTGRES_DB=db --name cengiz_postgres postgres
