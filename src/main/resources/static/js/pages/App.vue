<template>
    <v-app>
        <v-toolbar app>
            <v-toolbar-title>Robots</v-toolbar-title>
            <v-spacer></v-spacer>
            <span v-if="profile">{{profile.name}}</span>
            <v-btn v-if="profile" icon href="/logout">
                <v-icon>exit_to_app</v-icon>
            </v-btn>
        </v-toolbar>
        <v-content>
            <v-container v-if="!profile">Необходимо авторизоваться через
                <a href="/login">Google</a>
            </v-container>
            <v-container v-if="profile">
                <v-layout align-space-between justify-space-between column>
                    <div>
                        <robot-list :robots="robots"/>
                    </div>
                    <div>
                        <command-form :commands="commands"/>
                    </div>
                    <!--<v-layout align-center justify-space-around column>-->
                    <div>
                        <command-list :commands="commands"/>
                    </div>
                    <!--</v-layout>-->
                </v-layout>
            </v-container>
        </v-content>
    </v-app>
</template>
<script>
    import RobotList from 'components/robots/RobotList.vue'
    import CommandList from 'components/commands/CommandList.vue'
    import CommandForm from 'components/commands/CommandForm.vue'
    import {addHandler} from "../util/ws";
    import {getIndex} from "../util/collections";

    export default {
        components:{
            RobotList, CommandList, CommandForm
        },
        data(){
            return{
                profile: frontendData.profile,
                commands: frontendData.commands,
                robots: frontendData.robots
            }
        },
        created(){
            addHandler(data =>{
                let index = getIndex(this.commands,data)
                if(index>-1){
                    this.commands.splice(index,1,data)
                }else{
                    this.commands.push(data)
                }
            })
        }
    }
</script>
<style>

</style>