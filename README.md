kubectl create namespace myapp
helm install --namespace myapp pwned ./pwned
kubectl config set-context --current --namespace=myapp

###Port forwarding
kubectl port-forward service/pwned-chart 8000:777
kubectl port-forward service/postgres 5432:5432
