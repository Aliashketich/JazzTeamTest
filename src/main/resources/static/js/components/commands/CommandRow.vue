<template>
    <v-card>
        <v-card-title>
            <v-layout align-space-between justify-space-between row>
                <span>({{ command.id }})</span>
                <span>{{command.target}}</span>
                <span>{{command.type}}</span>
            </v-layout>
        </v-card-title>
    </v-card>
</template>

<script>

    export default {
        props: ['command']
    }
</script>

<style scoped>

</style>