<template>
    <v-layout align-center justify-center row fill-height>
        <v-text-field
                label="Target robot name"
                placeholder="Your target"
                v-model="target"
        />
        <v-text-field
                label="Type of command"
                placeholder="Command type"
                v-model="type"
        />
        <v-btn @click="execute">
            Execute
        </v-btn>
    </v-layout>
</template>

<script>
    import {sendCommand} from "../../util/ws";

    export default {
        props: ['commands'],
        data:function () {
            return{
                target:'',
                type:''
            }
        },
        methods:{
            execute() {
                sendCommand({id: this.id, target: this.target, type: this.type})
                this.target='';
                this.type=''

                /*let command ={target: this.target,type: this.type}
                this.$resource('/commands{/id}').save({},command).then(result=>result.json().then(data=>{
                    this.commands.push(data);
                    this.target='';
                    this.type=''
                }))*/
            }
        }
    }
</script>

<style>

</style>