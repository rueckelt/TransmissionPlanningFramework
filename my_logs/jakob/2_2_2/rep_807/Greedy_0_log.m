
% 2016-10-14 11:53:16

% my_logs/jakob/2_2_2/rep_807/Greedy_0_log.m
scheduling_duration_us = 8769;

% schedule
schedule_f_t_n(:,:,1) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 54, 0; 0, 0, 36, 0; 0, 0, 18, 0; 0, 0, 0, 66; 0, 0, 0, 66; 0, 0, 0, 66; 29, 0, 0, 0; 29, 0, 0, 0; 29, 0, 0, 0; 7, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,2) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,3) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 6, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];
schedule_f_t_n(:,:,4) = [0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 23, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0; 0, 0, 0, 0];

% cost function results
vioSt = [1944, 0, 840, 2254];
vioDl = [0, 0, 0, 5520];
vioNon = [0, 3520, 0, 63999];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 29, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 36, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 6, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0];
vioTp = [1084, 0, 10200, 0];
vioLcy = [0, 0, 2880, 0];
vioJit = [0, 0, 2520, 0];
cost_vio = 821661;
cost_switches = 2000;
cost_ch = 166320;
costTotal = 989981;

% Greedy_0
% 
% ############### Network 0 ##############
% cap	|[0]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[10]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[20]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[30]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[40]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[50]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[60]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[70]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[80]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[90]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|29	|29	|29	|7	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F2	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|6	|6	|6	|6	|6	|[50]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[60]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[70]6	|6	|6	|6	|6	|6	|6	|6	|6	|6	|[80]6	|6	|6	|6	|6	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|23	|23	|23	|23	|23	|23	|[80]23	|23	|23	|23	|23	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 1 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|21	|[90]42	|42	|42	|42	|42	|21	|0	|0	|0	|0	|
% ############### Network 2 ##############
% cap	|[0]0	|0	|0	|18	|36	|54	|54	|54	|54	|54	|[10]54	|36	|18	|0	|0	|0	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]54	|36	|18	|	|	|	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|
% ############### Network 3 ##############
% cap	|[0]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[10]0	|0	|0	|66	|66	|66	|0	|0	|0	|0	|[20]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[30]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[40]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[50]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[60]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[70]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[80]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|[90]0	|0	|0	|0	|0	|0	|0	|0	|0	|0	|
% F0	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|	|66	|66	|66	|	|	|	|	|[20]	|	|	|	|	|	|	|	|	|	|[30]	|	|	|	|	|	|	|	|	|	|[40]	|	|	|	|	|	|	|	|	|	|[50]	|	|	|	|	|	|	|	|	|	|[60]	|	|	|	|	|	|	|	|	|	|[70]	|	|	|	|	|	|	|	|	|	|[80]	|	|	|	|	|	|	|	|	|	|[90]	|	|	|	|	|	|	|	|	|	|

