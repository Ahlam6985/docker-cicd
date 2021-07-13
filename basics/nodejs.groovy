job('NodeJS example') { // Job NAME
    scm { // Configure Source control management 
        git('git://github.com/Ahlam6985/docker-cicd.git') {  node -> // is hudson.plugins.git.GitSCM
            node / gitConfigName('DSL User')
            node / gitConfigEmail('jenkins-dsl@domain.com')
        }
    }
    triggers { // Configure when to check for changes 
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('NodeJS example') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps { // what steps to take 
       shell("cd ./basics && npm install")
        }

    
}
