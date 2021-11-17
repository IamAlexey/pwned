kubectl create namespace myapp
helm install --namespace myapp pwned-chart ./pwned
kubectl config set-context --current --namespace=myapp

###Port forwarding
kubectl port-forward service/pwned-chart 8000:777
