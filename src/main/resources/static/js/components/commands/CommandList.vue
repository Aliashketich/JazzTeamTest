<template>
    <v-layout align-space-between justify-space-between column>
        <command-row v-for="command in commands" :key="command.id" :command="command"/>
    </v-layout>
</template>

<script>
    import CommandRow from 'components/commands/CommandRow.vue'
    export default {
        components:{
            CommandRow
        },
        props: ['commands']
    }
</script>

<style scoped>

</style>