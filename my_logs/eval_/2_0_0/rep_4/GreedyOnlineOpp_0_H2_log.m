
% 2016-12-02 16:24:17

% my_logs/eval_/2_0_0/rep_4/GreedyOnlineOpp_0_H2_log.m
scheduling_duration_us = 3953;

% schedule
schedule_f_t_n(:,:,1) = [0; 0; 0; 29; 29; 21; 21; 21; 21; 21; 21; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,2) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,3) = [0; 0; 0; 0; 0; 8; 8; 8; 8; 8; 8; 8; 8; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];
schedule_f_t_n(:,:,4) = [0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 21; 22; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0; 0];

% cost function results
vioSt = [0, 0, 0, 0];
vioDl = [0, 0, 0, 0];
vioNon = [3744, 660, 180, 0];
vioTpMin = [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0; 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0];
vioTp = [0, 0, 0, 544];
vioLcy = [0, 0, 1600, 0];
vioJit = [0, 0, 64, 0];
cost_vio = 53520;
cost_switches = 0;
cost_ch = 96030;
costTotal = 149550;

% GreedyOnlineOpp_0_H2
% 
% ############### Network 0 ##############
% cap	|[0]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[10]29	|29	|29	|29	|29	|29	|29	|29	|29	|29	|[20]29	|29	|29	|29	|29	|
% F0	|[0]	|	|	|29	|29	|21	|21	|21	|21	|21	|[10]21	|	|	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F2	|[0]	|	|	|	|	|8	|8	|8	|8	|8	|[10]8	|8	|8	|	|	|	|	|	|	|	|[20]	|	|	|	|	|
% F3	|[0]	|	|	|	|	|	|	|	|	|	|[10]	|	|21	|22	|	|	|	|	|	|	|[20]	|	|	|	|	|
