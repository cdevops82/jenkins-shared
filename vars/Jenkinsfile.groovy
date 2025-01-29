def call(Map pipelineParams) {
    stage('Checkout') {
        steps {
            git branch: pipelineParams.branch, url: pipelineParams.scmUrl
        }
    }

    stage('Build') {
        steps {
            sh 'echo Building project...'
        }
    }

    stage('Test') {
        steps {
            sh 'echo Running tests...'
        }
    }

    stage('Deploy') {
        steps {
            sh "echo Deploying to ${pipelineParams.developmentServer}:${pipelineParams.serverPort}"
        }
    }
}