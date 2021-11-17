kubectl create namespace myapp
helm install --namespace myapp pwned ./pwned
kubectl config set-context --current --namespace=myapp

###Port forwarding
kubectl port-forward service/pwned-chart 8000:777
kubectl port-forward service/postgres 5432:5432

sudo docker build -t my-app .
sudo docker tag my-app jcode8/my-app
sudo docker push jcode8/my-app